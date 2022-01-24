package com.btkAkademi.rentACar.ws.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btkAkademi.rentACar.business.abstracts.ColorService;
import com.btkAkademi.rentACar.business.dtos.ColorListDto;
import com.btkAkademi.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.btkAkademi.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.btkAkademi.rentACar.core.utilities.results.DataResult;
import com.btkAkademi.rentACar.core.utilities.results.Result;


@RestController
@RequestMapping("/api/colors")
@CrossOrigin
public class ColorsController {
	private ColorService colorService;

	public ColorsController(ColorService colorService) {
		this.colorService = colorService;
	}
	
	@GetMapping("getall")
	public DataResult<List<ColorListDto>> getAll()
	{
		return this.colorService.getAll();
	}
	
	@GetMapping("getbyid/{id}")
	public Result getById(@PathVariable int id) 
	{
		return colorService.getByColorId(id);	
	}
	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateColorRequest createColorRequest) 
	{
		return this.colorService.add(createColorRequest);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody @Valid UpdateColorRequest updateColorRequest) 
	{
		return this.colorService.update(updateColorRequest);
	}
	
	@DeleteMapping("delete/{id}")
	public Result delete(@Valid @PathVariable int id) {

		return this.colorService.delete(id);
	}
}
