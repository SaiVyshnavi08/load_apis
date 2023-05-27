package com.example.load_apis.Service;

import com.example.load_apis.DTOs.PayLoadDto;
import com.example.load_apis.Model.payLoad;
import com.example.load_apis.Repository.payLoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class payloadService {
    @Autowired
    payLoadRepository payloadRepository;

    public void addLoad(PayLoadDto payLoadDto) {
        payLoad Load = payLoad.builder().loadingPoint(payLoadDto.getLoadingPoint())

                .unloadingPoint(payLoadDto.getUnloadingPoint())
                .productType(payLoadDto.getProductType())
                .truckType(payLoadDto.getTruckType())
                .noOfTrucks(payLoadDto.getNoOfTrucks())
                .weight(payLoadDto.getWeight())
                .comment(payLoadDto.getComment())
                .shipperId(payLoadDto.getShipperId()).build();

        payloadRepository.save(Load);
    }


        public payLoad getLoadByShipperId(String shipperId){
           return payloadRepository.findByShipperId(shipperId);
        }

     public payLoad getLoadById(int Id){
        payLoad load = payloadRepository.findById(Id).get();
        return load;

     }

      public void updateLoad (int Id , PayLoadDto payLoadDto){
          Optional<payLoad> load = payloadRepository.findById(Id);

          if(load.isPresent()){
              payLoad existingLoad = load.get();
              existingLoad.setLoadingPoint(payLoadDto.getLoadingPoint());

              existingLoad.setUnloadingPoint(payLoadDto.getUnloadingPoint());
              existingLoad.setProductType(payLoadDto.getProductType());
              existingLoad.setTruckType(payLoadDto.getTruckType());
              existingLoad.setNoOfTrucks(payLoadDto.getNoOfTrucks());
              existingLoad.setWeight(payLoadDto.getWeight());
              existingLoad.setComment(payLoadDto.getComment());
              payloadRepository.save(existingLoad);


          }
      }

      public void deleteLoad(int id){
        Optional<payLoad> Load = payloadRepository.findById(id);
        if(Load.isPresent()){
            payloadRepository.delete(Load.get());

        }
      }


}
