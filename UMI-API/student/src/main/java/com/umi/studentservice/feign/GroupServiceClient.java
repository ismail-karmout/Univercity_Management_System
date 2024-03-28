package com.umi.studentservice.feign;

import com.umi.studentservice.model.Group;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "filiere-service")
public interface GroupServiceClient {
    @GetMapping("/api/groups/{id}")
    Group getGroupById(@PathVariable("id") Long id);

}
