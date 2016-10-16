package com.walmart.hackathon.resources;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.walmart.hackathon.model.BucketList;
import com.walmart.hackathon.persistence.BucketListDao;

@Path("/bucketLists")
public class BucketListResource {
	
	
	BucketListDao bucketListDao;
	
	@Inject
	public BucketListResource(BucketListDao bucketListDao) {
		this.bucketListDao=bucketListDao;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<BucketList> getBucketLists(){
		List<BucketList> bucketLists =bucketListDao.findAll();
		
		return bucketLists;
	}
	
	 /**
     * Create new USER
     * @param user
     * @return new user
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public BucketList save(@Valid BucketList bucketList) {
    return bucketListDao.save(bucketList);
    }
    
    @GET
    @Path("{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<BucketList> getGroupBuckets(@PathParam("groupId")  BigInteger groupId){
		List<BucketList> bucketLists =bucketListDao.getGroupBuckets(groupId);
		
		return bucketLists;
	}
}
