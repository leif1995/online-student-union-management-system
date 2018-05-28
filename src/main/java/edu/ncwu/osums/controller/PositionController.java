package edu.ncwu.osums.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ncwu.osums.entity.Position;
import edu.ncwu.osums.service.PositionService;
import edu.ncwu.osums.service.UserService;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @Autowired
    private UserService userService;

    @PostMapping("/findForDiagramByPositionName")
    @ResponseBody
    public Object findForDiagramByDepartmentName() {
        List<Object> objectList = new ArrayList<Object>();

        for (Position position : positionService.findAll()) {
            objectList.add(position);
        }

        objectList.add(userService.findCountByDepartmentName("%%") - 1);
        return objectList;
    }
}
