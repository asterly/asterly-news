package com.zbxh.swsrv.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/version/")
public class GetVersionController {
	
	
	private Properties properties ;
	private static String version=null;
	private static String title=null;
	
    public InputStream getIS(String file) {
    	return this.getClass().getClassLoader().getResourceAsStream(file);
    	
    }
	
    /**
     * 获取项目的版本好
     * @return
     */
	@RequestMapping("/getVersion")
	@ResponseBody
	public String GetVersion(ModelMap model) {

		InputStream is=  getIS("swsrvconfig.properties");
		properties=new Properties();
		try {
			properties.load(is);
			version=properties.getProperty("version");
			title=properties.getProperty("title");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
//		Gson json=new Gson();
//		Object obj=json.toJson(model);

		return version;
	}
	
	/**
	 * 修改软件的版本
	 * @param version
	 * @return
	 */
	@RequestMapping(value="/setVersion" ,method=RequestMethod.POST)
	@ResponseBody
	public String SetVersion(@PathVariable String version,ModelMap model) {
		InputStream is=  getIS("swsrvconfig.properties");
		properties=new Properties();
		try {
			properties.load(is);
			version=(String) properties.setProperty("version", version);
			model.addAttribute("upmsg", "修改成功");
		} catch (IOException e) {
			model.addAttribute("upmsg", "失败");
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return model.toString();
		
	}

}
