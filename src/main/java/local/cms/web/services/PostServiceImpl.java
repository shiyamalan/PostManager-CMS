package local.cms.web.services;

import java.util.List;

import local.cms.web.dao.PostDAO;
import local.cms.web.models.Post;

public class PostServiceImpl  implements PostService
{
	PostDAO postDAO;

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}

	public void createNewPost(Post post) {
		
		postDAO.createNewPost(post);
	}

	public void updatePost(Post post) {
		postDAO.updatePost(post);
	}

	public List<Post> listPost() {

		return postDAO.listPost();
	}

	public List<Post> getAllByUser(String userName) {
		// TODO Auto-generated method stub
		return postDAO.getAllByUser(userName);
	}

	public Post getById(int id) {
		// TODO Auto-generated method stub
		return postDAO.getById(id);
	}
	
	
	
}
