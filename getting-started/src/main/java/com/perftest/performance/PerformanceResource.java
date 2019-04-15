package com.perftest.performance;


import com.perftest.service.PerformanceService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class PerformanceResource {

    private PerformanceService performanceService = new PerformanceService();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String availableCommands() {
        return "Use /cpu /memory /tmp";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/cpu")
    public String testCpu() {
        return performanceService.measureCpuBasedPerformance();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/memory")
    public String testMemory() {
        return performanceService.measureMemoryBasedPerformance();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/tmp")
    public String testLocalFileSystem() {
        return performanceService.measureLocalFileSystemBasedPerformance();
    }

}