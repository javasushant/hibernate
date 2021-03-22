package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import com.nt.dto.InsurancePolicyDTO;
import com.nt.service.IInsurancePolicyMgmtService;
import com.nt.service.InsurancePolicyMgmtServiceImpl;
@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private IInsurancePolicyMgmtService service;
   
	public void init() throws ServletException {
		service=new InsurancePolicyMgmtServiceImpl();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		//use service
		try {
			InsurancePolicyDTO dto = service.fetchDetailsByPolicyId(id);
			//keep result in request scope
			req.setAttribute("dto", dto);
			RequestDispatcher rd = req.getRequestDispatcher("/show_result.jsp");
			rd.forward(req, res);
		}
		catch(HibernateException he) {
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
		}
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	public void destroy() {
		service= null;
	}
}
