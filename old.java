package com.example.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController		
public class Icontroller {
	@Autowired
    Iservice item;

    @RequestMapping(value="/getitem",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Items> getAllItems(){
        return item.getItems();
    }

    @RequestMapping(value="/getitem/{id}",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public  List<Items> getItems(@PathVariable String id) {
	List<Items> al= item.getItems(id);
	System.out.println(al);
	return al;
	}

    @RequestMapping(value="/additem",method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public String addItem(@RequestBody Items i){
        if(item.addItem(i)>= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }

    @RequestMapping(value="/updateitem/{id}",method = RequestMethod.PUT,produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void updateItems(@RequestBody Items item1, @PathVariable String id) {
	 int i =  item.updateItems(item1,id);
	 System.out.println("i value====>"+i);
	}
	
	@RequestMapping(value="/deleteitem/{id}",method = RequestMethod.DELETE,produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void deleteItems(@PathVariable String id) {
	 int i = item.deleteItems(id);
	 System.out.println("i value====>"+i);
	}
		
}