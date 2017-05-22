package local.cms.web.services;

import java.util.List;

import local.cms.web.models.Post;

/***
 * Post Service to manage the post information
 * 
 * @author shiyam
 * @since 1.0.0
 * @version 1.0.0
 */
public interface PostService {

	/***
	 * Create the new post in database
	 * 
	 * @param post
	 */
	void createNewPost(Post post);

	/***
	 * update the post information
	 * 
	 * @param post
	 */
	void updatePost(Post post);

	/***
	 * List the all post posted by all users
	 * 
	 * @return list of post
	 */
	List<Post> listPost();

	/***
	 * get the post for given user name
	 * 
	 * @param userName
	 * @return
	 */
	List<Post> getAllByUser(String userName);

	Post getById(int id);

}
