package br.com.fasttask.fasttask.service;

import java.util.List;

import br.com.fasttask.fasttask.model.Subitem;

public interface ISubitemService {

	public Subitem createSubitem(Subitem subitem);
    public Subitem updateSubitem(Subitem subitem);
    public void deleteSubitem(Subitem subitem);
    public Subitem findSubitemById(Integer subitemId);
    public List<Subitem> findAllSubitems();
    public List<Subitem> findSubitemsByTaskId(Integer taskId);
	
}
