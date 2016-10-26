package com.mycompany.myweb.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PhotoBoard {
	//1026
		private int bno;
		private String btitle;
		private String bcontent;
		private String bwriter;
		private int bhitcount;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date bdate;
		private String originalfile;
		private String savedfile;
		private String mimetype;
		
		public int getBno() {
			return bno;
		}
		public void setBno(int bno) {
			this.bno = bno;
		}
		public String getBtitle() {
			return btitle;
		}
		public void setBtitle(String btitle) {
			this.btitle = btitle;
		}
		public String getBcontent() {
			return bcontent;
		}
		public void setBcontent(String bcontent) {
			this.bcontent = bcontent;
		}
		public String getBwriter() {
			return bwriter;
		}
		public void setBwriter(String bwriter) {
			this.bwriter = bwriter;
		}
		public int getBhitcount() {
			return bhitcount;
		}
		public void setBhitcount(int bhitcount) {
			this.bhitcount = bhitcount;
		}
		public Date getBdate() {
			return bdate;
		}
		public void setBdate(Date bdate) {
			this.bdate = bdate;
		}
		public String getOriginalfile() {
			return originalfile;
		}
		public void setOriginalfile(String originalfile) {
			this.originalfile = originalfile;
		}
		public String getSavedfile() {
			return savedfile;
		}
		public void setSavedfile(String savedfile) {
			this.savedfile = savedfile;
		}
		public String getMimetype() {
			return mimetype;
		}
		public void setMimetype(String mimetype) {
			this.mimetype = mimetype;
		}
		
}
