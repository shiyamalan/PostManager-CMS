package local.cms.web.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import local.cms.web.models.Post;

/***
 * Encode the images to string format and save in a field
 * 
 * @author shiyam
 * @since 1.0.0
 * @version 1.0.0
 */
public class Util {

	public static Post converStringfromByte(Post post) {
		byte[] encodeBase64 = Base64.encodeBase64(post.getImage());

		String base64Encoded = null;
		try {
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		post.setImageSrc(base64Encoded);
		return post;
	}
}
