package com.alex_mono.service.impl;

import java.util.List;

import com.alex_mono.dao.ProductDao;
import com.alex_mono.domain.PageBean;
import com.alex_mono.domain.Product;
import com.alex_mono.service.ProductService;
import com.alex_mono.utils.BeanFactory;

public class ProductServiceImpl implements ProductService {

	@Override
	/**
	 * 查询热门商品
	 */
	public List<Product> findHot() throws Exception {
		ProductDao pd= (ProductDao) BeanFactory.getBean("ProductDao");
		return pd.findHot();
	}

	@Override
	/**
	 * 查询最新商品
	 */
	public List<Product> findNew() throws Exception {
		//ProductDao pd= (ProductDao) BeanFactory.getBean("ProductDao");
		ProductDao pd= (ProductDao) BeanFactory.getBean("ProductDao");
		return pd.findNew();
	}

	@Override
	/**
	 * 单个商品详情
	 */
	public Product getById(String pid) throws Exception {
		ProductDao pd=(ProductDao) BeanFactory.getBean("ProductDao");
		
		return pd.getById(pid);
	}

	@Override
	/**
	 * 分页展示分类商品
	 */
	public PageBean<Product> findByPage(int pageNumber, int pageSize, String cid) throws Exception {
		ProductDao pDao= (ProductDao) BeanFactory.getBean("ProductDao");
		//1.创建pagebean
		PageBean<Product> pb = new PageBean<>(pageNumber, pageSize);
		
		//2.设置当前页数据
		List<Product> data = pDao.findByPage(pb,cid);
		pb.setData(data);
		
		//3.设置总记录数
		int totalRecord = pDao.getTotalRecord(cid);
		pb.setTotalRecord(totalRecord);
		
		return pb;
	}

	@Override
	/**
	 * 后台展示已上架商品
	 */
	public List<Product> findAll() throws Exception {
		ProductDao pDao= (ProductDao) BeanFactory.getBean("ProductDao");
		return pDao.findAll();
	}

	@Override
	/**
	 * 保存商品
	 */
	public void save(Product p) throws Exception {
		ProductDao pDao= (ProductDao) BeanFactory.getBean("ProductDao");
		pDao.save(p);
		
	}

}
