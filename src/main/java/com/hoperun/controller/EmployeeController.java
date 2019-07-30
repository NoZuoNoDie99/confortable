package com.hoperun.controller;

import com.hoperun.pojo.Employee;
import com.hoperun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute @Validated Employee employee, BindingResult br, Model model) throws Exception {
		if(br.hasErrors()) {
			model.addAttribute("errors", br.getAllErrors());
			return "insert";
		}
		employeeService.insert(employee);
		return "redirect:showIndex.action";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer empno) throws Exception {
		employeeService.delete(empno);
		return "redirect:showIndex.action";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute @Validated Employee employee, BindingResult br, Model model) throws Exception {
		if(br.hasErrors()) {
			model.addAttribute("errors", br.getAllErrors());
			return "update";
		}
		employeeService.update(employee);
		return "redirect:showIndex.action";
	}

	@RequestMapping("/selectByLike")
	public String selectByLike(Employee employee, Model model) throws Exception {
		model.addAttribute("employees", employeeService.selectByLike(employee));
		return "index";
	}
	
	@RequestMapping("/showIndex")
	public ModelAndView showIndex() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employees", employeeService.selectAll());
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/showInsert")
	public String showInsert() {
		return "insert";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(Integer empno, Model model) throws Exception {
		model.addAttribute("employee", employeeService.selectByEmpno(empno));
		return "update";
	}
	
}
