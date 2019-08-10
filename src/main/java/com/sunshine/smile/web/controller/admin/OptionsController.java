package com.sunshine.smile.web.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshine.smile.model.domain.Options;
import com.sunshine.smile.model.dto.JsonResult;
import com.sunshine.smile.model.dto.SmileConst;
import com.sunshine.smile.model.enums.SmileEnums;
import com.sunshine.smile.service.OptionsService;

/**
 * @author :
 * @createDate :
 */

@Controller
@RequestMapping("/admin/option")
public class OptionsController extends BaseController {
	@Autowired
	private OptionsService optionsService;

	/**
	 * 所有设置选项
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String option(Model model) {
		return "admin/admin_options";
	}

	/**
	 * 保存设置
	 * 
	 * @param map
	 * @return
	 */
	@PostMapping(value = "/save")
	@ResponseBody
	public JsonResult save(@RequestParam Map<String, String> map) {
		try {
			optionsService.save(map);
			SmileConst.OPTIONS.clear();
			List<Options> listMap = optionsService.selectMap();
			for (Options options : listMap) {
				SmileConst.OPTIONS.put(options.getOptionName(), options.getOptionValue());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return new JsonResult(SmileEnums.PRESERVE_ERROR.isFlag(), SmileEnums.PRESERVE_ERROR.getMessage());
		}
		return new JsonResult(SmileEnums.PRESERVE_SUCCESS.isFlag(), SmileEnums.PRESERVE_SUCCESS.getMessage());
	}
}
