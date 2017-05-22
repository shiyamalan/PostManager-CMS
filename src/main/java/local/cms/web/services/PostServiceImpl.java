package local.cms.web.services;

import java.util.List;

import local.cms.web.dao.PostDAO;
import local.cms.web.models.Post;

public class PostServiceImpl implements PostService {
	PostDAO postDAO;

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}

	public void createNewPost(Post post) {

		postDAO.createNewPost(post);
	}

	/***
	 * @see local.cms.web.services.PostService#updatePost(local.cms.web.models.Post)
	 */
	public void updatePost(Post post) {
		postDAO.updatePost(post);
	}

	/***
	 * @see local.cms.web.services.PostService#listPost()
	 */

	public List<Post> listPost() {

		return postDAO.listPost();
	}

	/***
	 * @see local.cms.web.services.PostService#getAllByUser(java.lang.String)
	 */
	public List<Post> getAllByUser(String userName) {
		// TODO Auto-generated method stub
		return postDAO.getAllByUser(userName);
	}

	/***
	 * @see local.cms.web.services.PostService#getById(int)
	 */
	public Post getById(int id) {
		// TODO Auto-generated method stub
		return postDAO.getById(id);
	}

}
