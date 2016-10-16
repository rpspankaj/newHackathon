package com.walmart.hackathon.persistence;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.walmart.hackathon.model.BucketList;

public interface BucketListDao extends JpaRepository<BucketList,BigInteger>{

	@Query("select b from BucketList b where b.userGroupId = ?1")
	public List<BucketList> getGroupBuckets(BigInteger groupId);   

}
