
import React, { useState } from 'react';
import axios from 'axios';
import './style.css';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/user/login', {
        email,
        password,
      });
      const token = response.data.token;
      localStorage.setItem('token', token);
      window.location.href = '/tasks';
    } catch (err) {
      if (axios.isAxiosError(err)) {
        setError(err.response?.data.message || 'Erro ao logar');
      } else {
        setError('Erro ao logar');
      }    
    }
  };

  return (
    <div className="login-container">
      <h1>Login</h1>
      <form className="login-form" onSubmit={handleSubmit}>
        <label>Email:</label>
        <input type="email" value={email} onChange={(event) => setEmail(event.target.value)} />
        <label>Senha:</label>
        <input type="password" value={password} onChange={(event) => setPassword(event.target.value)} />
        <button type="submit">Logar</button>
        {error && <p className="error-message">{error}</p>}
      </form>
    </div>
  );
};

export default LoginPage;