package com.yeonho.springinit;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class HateoasController {

    @GetMapping("/hateoas")
    public HttpEntity<Hateoas> hateoas() {
        Hateoas hateoas = new Hateoas();
        hateoas.setName("ji han");
        hateoas.setPrefix("Hey,");
        hateoas.add(linkTo(methodOn(HateoasController.class).hateoas()).withSelfRel());;
        return new ResponseEntity<>(hateoas, HttpStatus.OK);
    }
}
