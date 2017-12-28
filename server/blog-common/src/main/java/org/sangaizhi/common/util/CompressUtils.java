package org.sangaizhi.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.tools.bzip2.CBZip2InputStream;
import org.apache.tools.bzip2.CBZip2OutputStream;

/**
 * @ClassName: CompressUtils
 * @Description: 压缩工具类
 * @author: wupeng
 * @date: 2016年9月6日 下午4:28:07
 */
public class CompressUtils {

	/**
	 * 将返回的结果集进行gzip压缩
	 * 
	 * @param result api返回结果，json格式
	 * @param response
	 * @author: wupeng
	 * @date: 2016年9月6日 下午5:45:23
	 */
	public static void gzipOutput(String result, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		// response.setHeader("Content-Type","application/gzip");
		response.setHeader("Content-Encoding", "gzip");
		// 解决前端js跨域请求的问题，暂时信任任何域名
		 response.setHeader("Access-Control-Allow-Origin", "*");
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			byte[] zipBytes = gzipCompress(result.getBytes("UTF-8"));
			sos.write(zipBytes);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sos.flush();
				sos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * gzip压缩
	 * 
	 * @param data 待压缩字节数组
	 * @return byte[] 压缩后的字节数组
	 * @author: wupeng
	 * @date: 2016年9月6日 下午4:33:41
	 */
	public static byte[] gzipCompress(byte[] data) {
		byte[] byteArr = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(bos);
			gzip.write(data);
			gzip.finish();
			gzip.close();
			byteArr = bos.toByteArray();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArr;
	}

	/**
	 * gzip压缩
	 * 
	 * @param str
	 * @return byte[]
	 * @author: wupeng
	 * @date: 2016年9月6日 下午4:58:05
	 */
	public static byte[] gzipCompress(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		byte[] byteArr = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(bos);
			gzip.write(str.getBytes("UTF-8"));
			gzip.finish();
			gzip.close();
			byteArr = bos.toByteArray();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArr;
	}

	/**
	 * gzip压缩
	 * 
	 * @param str
	 * @return String
	 * @author: wupeng
	 * @date: 2016年9月6日 下午4:55:44
	 */
	public static String gzipCompress2String(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		String result = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(out);
			gzip.write(str.getBytes());
			gzip.close();
			result = out.toString("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * gzip解压
	 * 
	 * @param data 压缩的字节数组
	 * @return byte[] 解压后的字节数组
	 * @author: wupeng
	 * @date: 2016年9月6日 下午4:36:38
	 */
	public static byte[] gzipUncompress(byte[] data) {
		byte[] byteArr = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
			GZIPInputStream gzip = new GZIPInputStream(bis);
			byte[] buf = new byte[1024];
			int num = -1;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((num = gzip.read(buf, 0, buf.length)) != -1) {
				baos.write(buf, 0, num);
			}
			byteArr = baos.toByteArray();
			baos.flush();
			baos.close();
			gzip.close();
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArr;
	}

	/**
	 * gzip解压
	 * 
	 * @param str
	 * @return String
	 * @author: wupeng
	 * @date: 2016年9月6日 下午5:06:22
	 */
	public static String gzipUncompress(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		String result = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("UTF-8"));
			GZIPInputStream gunzip = new GZIPInputStream(in);
			byte[] buffer = new byte[256];
			int n;
			while ((n = gunzip.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
			result = out.toString("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * zip压缩
	 * 
	 * @param data
	 * @return byte[]
	 * @author: wupeng
	 * @date: 2016年9月6日 下午5:07:36
	 */
	public static byte[] zipCompress(byte[] data) {
		byte[] byteArr = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ZipOutputStream zip = new ZipOutputStream(bos);
			ZipEntry entry = new ZipEntry("zip");
			entry.setSize(data.length);
			zip.putNextEntry(entry);
			zip.write(data);
			zip.closeEntry();
			zip.close();
			byteArr = bos.toByteArray();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArr;
	}

	/**
	 * zip解压
	 * 
	 * @param data
	 * @return byte[]
	 * @author: wupeng
	 * @date: 2016年9月6日 下午4:41:31
	 */
	public static byte[] zipUncompress(byte[] data) {
		byte[] byteArr = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
			ZipInputStream zip = new ZipInputStream(bis);
			while (zip.getNextEntry() != null) {
				byte[] buf = new byte[1024];
				int num = -1;
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				while ((num = zip.read(buf, 0, buf.length)) != -1) {
					baos.write(buf, 0, num);
				}
				byteArr = baos.toByteArray();
				baos.flush();
				baos.close();
			}
			zip.close();
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArr;
	}

	/**
	 * bzip2压缩
	 * 
	 * @param data
	 * @return byte[]
	 * @author: wupeng
	 * @date: 2016年9月6日 下午5:19:23
	 */
	public static byte[] bzip2Compress(byte[] data) {
		byte[] byteArr = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			CBZip2OutputStream bzip2 = new CBZip2OutputStream(bos);
			bzip2.write(data);
			bzip2.flush();
			bzip2.close();
			byteArr = bos.toByteArray();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArr;
	}

	/**
	 * bzip2解压
	 * 
	 * @param data
	 * @return byte[]
	 * @author: wupeng
	 * @date: 2016年9月6日 下午5:20:11
	 */
	public static byte[] bzip2Uncompress(byte[] data) {
		byte[] byteArr = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
			CBZip2InputStream bzip2 = new CBZip2InputStream(bis);
			byte[] buf = new byte[1024];
			int num = -1;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((num = bzip2.read(buf, 0, buf.length)) != -1) {
				baos.write(buf, 0, num);
			}
			byteArr = baos.toByteArray();
			baos.flush();
			baos.close();
			bzip2.close();
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArr;
	}
}
