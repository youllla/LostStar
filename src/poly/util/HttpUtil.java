package poly.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {
	public static String MapToQeuryString(HashMap<String, String> map, String charSet){
		StringBuilder sbQuery = new StringBuilder();

		try {
			Iterator<Entry<String, String>> iter = map.entrySet().iterator();
			while(iter.hasNext()){
				Entry<String, String> entry = iter.next();
				String key = entry.getKey();
				String value = entry.getValue();

				sbQuery.append("&");
				sbQuery.append(URLEncoder.encode(key, charSet) + "=" +URLEncoder.encode(value, charSet));
			}
			sbQuery.delete(0, 0);
		} catch (Exception e) {

		}

		return sbQuery.toString();
	}


	/**
	 * URL을 호출하는 기능
	 * @param sURL
	 * @param getData
	 * @param postData
	 * @param encType
	 * @return
	 */
	public static Object callURL(String sURL, HashMap<String, String> getData, HashMap<String, String> postData, String charSet){
        HashMap<String, String> hashmapResult = new HashMap<String, String>();

        URL url;
        HttpURLConnection urlConnection;

        String getParams = MapToQeuryString(getData, charSet);
        String postParams = MapToQeuryString(postData, charSet);

        if (!"".equals(getParams)){
        	sURL += "?" + getParams;
        }
        try {
			url = new URL(sURL);
			urlConnection = (HttpURLConnection) url.openConnection();
	        urlConnection.setDoOutput(true);
	        urlConnection.setInstanceFollowRedirects(false);
	        urlConnection.setRequestMethod("POST");
	        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        urlConnection.setRequestProperty("charset", charSet);

			byte[] bytePostData	= postParams.getBytes(charSet);
			int postDataLength	= bytePostData.length;
			urlConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			urlConnection.setUseCaches(false);
			urlConnection.getOutputStream().write(bytePostData);

			StringBuilder sb = new StringBuilder();
			Reader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			for (int c = 0; (c = in.read()) >=0; ) {
				sb.append((char)c);
			}
			String responseBody = sb.toString();
	        int httpStatus = urlConnection.getResponseCode();

	        hashmapResult.put("httpStatus", String.valueOf(httpStatus));
	        hashmapResult.put("responseBody", responseBody);
		} catch (IOException e) {
			e.printStackTrace();
        } catch(IllegalArgumentException e){
			e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return hashmapResult;
	}

	
	public static Object callURLGet(String sURL, String charSet){
        HashMap<String, String> hashmapResult = new HashMap<String, String>();

        URL url;
        HttpURLConnection urlConnection;

        try {
			url = new URL(sURL);
			urlConnection = (HttpURLConnection) url.openConnection();
	        urlConnection.setDoOutput(true);
	        urlConnection.setInstanceFollowRedirects(false);
	        urlConnection.setRequestMethod("GET");
	        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        urlConnection.setRequestProperty("charset", charSet);

			/*byte[] bytePostData	= postParams.getBytes(charSet);
			int postDataLength	= bytePostData.length;
			urlConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			urlConnection.setUseCaches(false);
			urlConnection.getOutputStream().write(bytePostData);*/

			StringBuilder sb = new StringBuilder();//문자열 더해주는것 
			Reader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			for (int c = 0; (c = in.read()) >=0; ) {
				sb.append((char)c);
			}
			String responseBody = sb.toString();
	        int httpStatus = urlConnection.getResponseCode();//http 응답 코드 404 200성공 400! 에러 500 서버 에러

	        hashmapResult.put("httpStatus", String.valueOf(httpStatus));
	        hashmapResult.put("responseBody", responseBody);
		} catch (IOException e) {
			e.printStackTrace();
        } catch(IllegalArgumentException e){
			e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return hashmapResult;
	}
	
	/**
	 * POST 값을 포함한 모든 Request의 body값을 읽어온다.
	 * @return
	 */
	public static String getRequestBody(HttpServletRequest request) throws IOException {
		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null){
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while((bytesRead = bufferedReader.read(charBuffer)) > 0){
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null){
				try {
					bufferedReader.close();
				} catch (Exception ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();
		return body;
	}

}

