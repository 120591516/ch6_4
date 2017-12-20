package com.wisely.ch6_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.spring_boot_start_hello.HelloService;

@SpringBootApplication
// 关闭特定的自动配置
// exclude 值为class<?> 多个逗号隔开
//@SpringBootApplication(exclude = { Ch64Application.class, Ch64Application.class })
/*
 * spring boot 提倡零配置，即无xml配置
 * @ImportResource 针对于特殊的要求配置xml文件
 *	eg @ImportResource({ "classpath:some-context.xml", "classpath:some-context.xml" })
 */
//@ImportResource({ "classpath:some-context.xml", "classpath:some-context.xml" })
// @RestController
/*
 * @RestController 是一个组合注解，组合了@controller 和@ResponseBody
 */
@RestController
public class Ch64Application {
	@Autowired
	HelloService helloService;

	@RequestMapping("/index")
	public String index() {
		return helloService.sayHello();
	}
	public static void main(String[] args) {
		// 自定义启动方式
		/**
		 * 第一种方式
		 */
		SpringApplication app = new SpringApplication(Ch64Application.class);
		// 关闭banner
		app.setBannerMode(Banner.Mode.OFF);
		// 启动
		app.run(args);
		/**
		 * 第二种方式
		 */
//		new SpringApplicationBuilder(Ch64Application.class).bannerMode(Banner.Mode.OFF).run(args);

		// spring 默认的启动方式
		// SpringApplication.run(Ch64Application.class, args);
	}
}
