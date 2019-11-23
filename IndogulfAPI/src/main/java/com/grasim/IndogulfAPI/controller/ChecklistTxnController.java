package com.grasim.IndogulfAPI.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grasim.IndogulfAPI.model.ChecklistTxnHdr;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.repository.ChecklistTxnRepository;
import com.grasim.IndogulfAPI.service.ChecklistTxnService;

@RestController
@RequestMapping("chklist_txn")
public class ChecklistTxnController {
	
/*	@Autowired
	private ChecklistTxnRepository chklistRepo;
	*/
	@Autowired
	private ChecklistTxnService checklistTxnService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public WebAPIResponse<ChecklistTxnHdr> save(@RequestBody ChecklistTxnHdr chklist) {
		return checklistTxnService.saveChecklistTxn(chklist);
	}
	
	@RequestMapping(value = "/save_all", method = RequestMethod.POST)
	public WebAPIResponse<List<ChecklistTxnHdr>> saveAll(@RequestBody List<ChecklistTxnHdr> chklists) {
		return checklistTxnService.saveAllChecklistTxn(chklists);
	}
	
	@RequestMapping(value = "/user/{userid}/updates/{revid}", method = RequestMethod.GET)
	public WebAPIResponse<ChecklistTxnHdr> getAllByUserRevIdAndPagination(
			@RequestParam(value = "from", required = false) String from, @RequestParam(value = "size", required = false) String size,
			@PathVariable("userid") String userid, @PathVariable("revid") Long revid, HttpServletRequest request) {
		
		from = request.getParameter("from");
		size = request.getParameter("size");
		return checklistTxnService.getAllByUserRevIdAndPagination(Long.parseLong(userid), revid, Integer.parseInt(from), Integer.parseInt(size));
	}
	
	@RequestMapping(value = "/role/{roleid}/updates/{revid}", method = RequestMethod.GET)
	public WebAPIResponse<ChecklistTxnHdr> getAllByRoleRevIdAndPagination(
			@RequestParam(value = "from", required = false) String from, @RequestParam(value = "size", required = false) String size,
			@PathVariable("roleid") String roleid, @PathVariable("revid") Long revid, HttpServletRequest request) {
		
		from = request.getParameter("from");
		size = request.getParameter("size");
		return checklistTxnService.getAllByRoleRevIdAndPagination(Long.parseLong(roleid), revid, Integer.parseInt(from), Integer.parseInt(size));
	}
	
	/*@RequestMapping(value = "/empcode/{empcode}")
	public List<ChecklistTxnHdr> save(@PathVariable("empcode") Long empcode) {
		List<ChecklistTxnHdr> chklistHdr = chklistRepo.getChecklistHdrByEmp(empcode);
		return chklistHdr;
	}*/
}
