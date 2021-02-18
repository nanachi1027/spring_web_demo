package org.example.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.model.VersionModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Mae
 * @Date: 2021/2/18 3:37 上午
 */
@RestController
@RequestMapping(value = "/version", produces = {"application/json"})
@Api(tags = {"Common"})
public class Version {
    @ApiOperation(value = "Gets the version of REST API", notes = "", response = VersionModel.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Returns the version info for the REST API.", response = VersionModel.class)})
    @RequestMapping(method = RequestMethod.GET)
    public VersionModel getVersion() {
        VersionModel r = new VersionModel();
        r.setVersion("1.0.0");
        r.setMajor(1);
        r.setMinotr(0);
        r.setPatch(0);
        return r;
    }
}
