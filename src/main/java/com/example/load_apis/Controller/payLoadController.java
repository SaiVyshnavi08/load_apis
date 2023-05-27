package com.example.load_apis.Controller;

import com.example.load_apis.DTOs.PayLoadDto;
import com.example.load_apis.Model.payLoad;
import com.example.load_apis.Service.payloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/load")
public class payLoadController {

    @Autowired
    payloadService payloadservice;

    @PostMapping("/add")
    public ResponseEntity<String> AddLoad(@RequestBody PayLoadDto payloadDto){
      payloadservice.addLoad(payloadDto);
      return new ResponseEntity<>("loads details added successfully" , HttpStatus.OK);
    }

    @GetMapping("/Get_load")
    public payLoad getLoadByShipperID(@RequestParam("shipperId") String shipperId ){
     return payloadservice.getLoadByShipperId(shipperId);
    }

    @GetMapping("/get_load_by_id/{id}")
    public payLoad getLoadById(@PathVariable("id") int Id){
     return payloadservice.getLoadById(Id);
    }

    @PutMapping("/load/{id}")
    public void updateLoad(@PathVariable("id") int Id , @RequestBody PayLoadDto payLoadDto){
        payloadservice.updateLoad(Id, payLoadDto);
    }
    @DeleteMapping("/delete_load")
    public ResponseEntity<String> deleteLoad(@RequestParam("Id") int LoadId){
      payloadservice.deleteLoad(LoadId);
      return new ResponseEntity<>("Deleted succesfully" , HttpStatus.OK);
    }

}
