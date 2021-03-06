package com.litbo.hospitalzj.quality.service.impl;
/**
 * 设备品名业务层
 * @author 刘洋
 *
 */

		import java.util.List;

        import com.litbo.hospitalzj.supplier.service.exception.DeleteException;
		import com.litbo.hospitalzj.supplier.service.exception.FindIsNullException;
		import com.litbo.hospitalzj.supplier.service.exception.InsertException;
		import org.apache.ibatis.annotations.Param;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Service;

		import com.litbo.hospitalzj.quality.entity.EqPm;
		import com.litbo.hospitalzj.quality.mapper.EqPmMapper;
		import com.litbo.hospitalzj.quality.service.EqPmService;

@Service
public class EqPmServiceImpl implements EqPmService{
	@Autowired
	private EqPmMapper eqPmMapper;

	@Override
	public EqPm getById(Integer eqPmId) {
		return findById(eqPmId);
	}


	public EqPm findByName(String eqPmName) {
		return eqPmMapper.findByName(eqPmName);
	}

	private EqPm findById(Integer eqPmId) {
		return eqPmMapper.findById(eqPmId);
	}
	@Override
	public List<EqPm> getAll() {
		return eqPmMapper.findAll();
	}

	@Override
	public void delete(Integer eqPmId, Integer isDelete) {
		EqPm data=findById(eqPmId);
		if(data==null){
			throw new DeleteException("设备品名不存在");
		}
		eqPmMapper.delete(eqPmId,isDelete);
	}

	@Override
	public void insert(EqPm eqPm) {;
		EqPm data=findByName(eqPm.getEqPmName());
		if(data!=null){
			throw new InsertException("设备品名或名称已存在");
		}
		eqPmMapper.insert(eqPm);
	}

	@Override
	public EqPm update(EqPm eqPm) {
		eqPmMapper.update(eqPm);
		return eqPm;
	}
	//通过useriD查询所分配的设备pm
	@Override
	public List<EqPm> findJcPmByUserId(String userId) {
		return eqPmMapper.findJcPmByUserId(userId);
	}
	//通过useriD查询未分配的设备pm
	@Override
	public List<EqPm> findJcPmNotByUserId(String userId) {
		return eqPmMapper.findJcPmNotByUserId(userId);
	}
	//通过yqId查询所分配的设备pm
	@Override
	public List<EqPm> findYqPmByYqId(String yqId) {
		return eqPmMapper.findYqPmByYqId(yqId);
	}
	//通过yqId查询未分配的设备pm
	@Override
	public List<EqPm> findYqPmNotByYqId(String yqId) {
		return eqPmMapper.findYqPmNotByYqId(yqId);
	}
	//模糊查询名称
	@Override
	public List<EqPm> findPmLike(String eqPmName) {
		List<EqPm> data=eqPmMapper.findPmLike(eqPmName);
		if(data==null){
			throw new FindIsNullException("您查找的数据不存在");
		}
		return eqPmMapper.findPmLike(eqPmName);
	}
}