package com.compassites.channels.dao;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.Exception.ChannelException;
import com.compassites.channels.daoModel.ChannelModel;
import com.compassites.channels.restModel.ChannelRestModel;

@Repository
public class ChannelDAOImpl implements ChannelDAO {

	@Autowired
	@Qualifier("channelsJdbcTemplate") 
	private JdbcTemplate jdbcTemplate;
	/*
	 * @Autowired 
	 * private MessageUtil messagesUtil;
	 */
	@Autowired
	private Environment env;
	
	@Value("${profile.images.dir}")
	private String profileImagesDir;

	@Value("${profile.image.url}")
	private String profileImageUrl;

	@Override
	public int createChannels(ChannelRestModel channels) {

		UUID uuid = UUID.randomUUID();
		String channelId = uuid.toString();

		String createdDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		createdDate = sdf.format(new Date());

		String sql = "INSERT INTO channels(channel_id, channel_created_user_id, channel_title, channel_profile_image_path, channel_description, channel_prefer_gender, created_date, modified_user_id) VALUES(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, channelId, channels.getChannelCreatedUserId(), channels.getChannelTitle(),
				channels.getChannelProfileImagePath(), channels.getChannelDescription(),
				channels.getChannelPreferGender(), createdDate, channels.getModifiedUserId());
	}

	@Override
	public ChannelModel retreiveChannels(String channelId) throws ChannelException {

		Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM channels where channel_id = ?",
				Integer.class, channelId);
		
		String selectQuery = "select * from channels where channel_id = ?";

		if (count > 0) {
			ChannelModel channelModel = (ChannelModel) jdbcTemplate.queryForObject(selectQuery, new Object[] { channelId },
					new BeanPropertyRowMapper(ChannelModel.class));
			return channelModel;
		}
		else{
			throw new ChannelException("Invalid Channel Id. Please Enter a valid Channel Id. ");
		}
	}

	@Override
	public int deleteChannel(String channelId) {
		String sql = "DELETE FROM channels where channel_id = ?";
		return jdbcTemplate.update(sql, channelId);
	}

	@Override
	public int updateChannels(ChannelRestModel channelModel, String channelId) {
		String sql = "UPDATE channels SET  channel_created_user_id = ? , channel_title = ? , channel_profile_image_path = ?, channel_description = ? , channel_prefer_gender = ? , modified_user_id = ? WHERE channel_id = ? ";
		return jdbcTemplate.update(sql, channelModel.getChannelCreatedUserId(), channelModel.getChannelTitle(),
				channelModel.getChannelProfileImagePath(), channelModel.getChannelDescription(),
				channelModel.getChannelPreferGender(), channelModel.getModifiedUserId(), channelId);
	}

	@Override
	public String saveProfileImage(MultipartFile profileImage,String mobnumb, String channelId) {

		return this.getFile(profileImage,mobnumb,channelId);
	}
	
	

	@Override
	public String uploadContent(MultipartFile profileImage, String mobnumb, String channelId) {
		return this.getFile(profileImage,mobnumb,channelId);
	}
	

	public String getFile(MultipartFile profileImage,String mobnumb,String channelId) {
		File file = null;
		try {

			String profileImagesDir = env.getProperty("profile.image.url");
			String uploadingDir = profileImagesDir + "/"+channelId+"/";

			boolean flag = new File(uploadingDir).mkdirs();
			
			String fileExtension = this.getFileExtension(profileImage.getOriginalFilename());
			//UUID fileName_UUID = UUID.randomUUID();
			file = new File(uploadingDir + mobnumb + "-"+ channelId + "." + fileExtension);
			/*Tika tika = new Tika();
			String filetype = tika.detect(file);*/
			profileImage.transferTo(file);
				

		} catch (IllegalStateException e) {
			System.out.println("Illigal Exception");
			return null;
			// log.error("Error : getFilePath : " + e);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
			// log.error("Error : getFilePath : " + e);
		}

		return file.getPath();
	}

	public String getFileExtension(String fileName) {
		String fileExtension = null;

		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		}

		return fileExtension;
	}

	@Override
	public ChannelModel retreiveChannelsByName(String channelName) {
		String selectQuery = "select * from channels where channel_title = ?";

		ChannelModel channelModel = (ChannelModel) jdbcTemplate.queryForObject(selectQuery, new Object[] { channelName },
				new BeanPropertyRowMapper(ChannelModel.class));

		return channelModel;
	}

	@Override
	public List<ChannelModel> getChannelDetails(List<String> channelIds) {
		List<ChannelModel> channelModelList = new ArrayList<>();
		
		String selectQuery = "select * from channels where channel_id = ?";
		
		for(String channelId : channelIds){
			ChannelModel channelModel = (ChannelModel) jdbcTemplate.queryForObject(selectQuery, new Object[] { channelId },
					new BeanPropertyRowMapper(ChannelModel.class));
			
			channelModelList.add(channelModel);
		}
		
		return channelModelList;
	}
}
