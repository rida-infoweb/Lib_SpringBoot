package com.mglcl.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mglcl.dto.EmpruntDTO;
import com.mglcl.services.EmpruntService;
@RestController
@RequestMapping("/api/emprunts")
public class EmpruntRestController {
	private EmpruntService empruntService;
	@Autowired
	private ModelMapper modelMapper;

	
	public EmpruntRestController(EmpruntService empruntService) {
		super();
		this.empruntService = empruntService;
	}
	
	
	
	@GetMapping
	public List<EmpruntDTO> getAllEmprunts() {

		return empruntService.getAllEmprunts().stream().map(post -> modelMapper.map(post, EmpruntDTO.class))
				.collect(Collectors.toList());
	}

}
