package com.amitnadav.mywarehousemanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubmissionSuccess implements SubmissionStatus{

    private OrderRequest orderRequest;
}
