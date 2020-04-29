package de.springboot.controller;

import com.google.common.collect.ImmutableList;
import de.springboot.model.StackoverflowWebsite;
import de.springboot.service.StackOverflowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StackOverflowControllerTest {

    @Mock
    private StackOverflowService service;

    @InjectMocks
    private StackOverflowController stackOverflowController;

    @Test
    public void getListOfProviders() {
        when(service.findAll()).thenReturn(ImmutableList.of());

        List<StackoverflowWebsite> list = stackOverflowController.getListOfProviders();

        verify(service).findAll();
    }
}