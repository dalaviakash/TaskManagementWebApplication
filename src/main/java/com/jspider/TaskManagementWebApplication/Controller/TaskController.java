package com.jspider.TaskManagementWebApplication.Controller;

import com.jspider.TaskManagementWebApplication.Model.Task;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class TaskController {



    //used List to store data
        List<Task> taskData=new ArrayList<>();
        {
            taskData.add(new Task(1,"code","Coding Assignment"));
        }

        //see all data
        @GetMapping("/")
        public String getAllTasks(Model model){
            model.addAttribute("records",taskData);
            return "taskslist";
        }

        //add tasks
        @GetMapping("/addtasksform")  //form display
        public  String displayTask(Model model){
            model.addAttribute("product",new Task());
            return "addtasksform";
        }

        //Insert task
        @PostMapping("/inserttasks")     //insert
        public String addTaskDetails(Task t) {
            taskData.add(t);
            return "redirect:/";
        }

        //update tasks
        @GetMapping("/updatetaskslist/{id}")
        public String showUpdateForm(@PathVariable(value = "id") int id , Model model){
            Task t=taskData.get(id-1);
            model.addAttribute("product",t);
            return "updatetaskslist";
        }

        //modify tasks
        @GetMapping("/modifytasks")
        public String changeTasks(Task t){
            taskData.set(t.getTasksId()-1,t);
            return "redirect:/";
        }

        //delete tasks
        @GetMapping("/deletetasks/{id}")
        public String deleteTask(@PathVariable(value = "id") int id ){
            Task t=taskData.get(id-1);
            taskData.remove(t);
            return "redirect:/";

        }

    }


