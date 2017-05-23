package com.compassites.channels.dao;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.daoModel.ChannelModel;

import com.compassites.channel.utils.MessageUtil;

@Repository
public class ChannelDAOImpl implements ChannelDAO {

	@Autowired
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
	public int createChannels(ChannelModel channels) {
		String sql = "INSERT INTO channels(channel_id, channel_created_user_id, channel_title, channel_profile_image_path, channel_description, channel_prefer_gender, 	created_date, modified_user_id, modified_date, isactive) VALUES(?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, channels.getChannel_id(), channels.getChannel_created_user_id(),
				channels.getChannel_title(), channels.getChannel_profile_image_path(),
				channels.getChannel_description(), channels.getChannel_prefer_gender(), channels.getCreated_date(),
				channels.getModified_user_id(), channels.getModified_date(), channels.getIsactive());

	}

	@Override
	public ChannelModel retreiveChannles(int channel_id) {

		String selectQuery = "select * from channels where channel_id = ?";

		ChannelModel channelModel = (ChannelModel) jdbcTemplate.queryForObject(selectQuery, new Object[] { channel_id },
				new BeanPropertyRowMapper(ChannelModel.class));

		return channelModel;

	}

	@Override
	public int deleteChannel(int channel_id) {
		String sql = "DELETE FROM channels where channel_id = ?";
		return jdbcTemplate.update(sql, channel_id);
	}

	@Override
	public int updateChannels(ChannelModel channelModel, int channel_id) {
		String sql = "UPDATE channels SET  channel_created_user_id = ? , channel_title = ? , channel_profile_image_path = ?, channel_description = ? , channel_prefer_gender = ? , created_date = ? , modified_user_id = ? , modified_date = ? , isactive = ? WHERE channel_id = ? ";
		return jdbcTemplate.update(sql, channelModel.getChannel_created_user_id(), channelModel.getChannel_title(),
				channelModel.getChannel_profile_image_path(), channelModel.getChannel_description(),
				channelModel.getChannel_prefer_gender(), channelModel.getCreated_date(),
				channelModel.getModified_user_id(), channelModel.getModified_date(), channelModel.getIsactive(),
				channelModel.getChannel_id());
	}

	@Override
	public String saveProfileImage(MultipartFile profileImage,String mobnumb, int channel_id) {

		return this.getFile(profileImage,mobnumb,channel_id);
	}
	
	

	@Override
	public String uploadContent(MultipartFile profileImage, String mobnumb, int channel_id) {
		return this.getFile(profileImage,mobnumb,channel_id);
	}
	

	public String getFile(MultipartFile profileImage,String mobnumb,int channel_id) {
		File file = null;
		try {

			String profileImagesDir = env.getProperty("profile.image.url");
			String uploadingDir = profileImagesDir + "/"+channel_id+"/";

			boolean flag = new File(uploadingDir).mkdirs();
			
			String fileExtension = this.getFileExtension(profileImage.getOriginalFilename());
			//UUID fileName_UUID = UUID.randomUUID();
			file = new File(uploadingDir + mobnumb + "-"+ channel_id + "." + fileExtension);
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


}
