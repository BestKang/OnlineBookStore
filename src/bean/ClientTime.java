package bean;

import java.util.Date;

public class ClientTime {
		private String t;
		public ClientTime(){
			this.t=new Date().toLocaleString();
		}
		public String getT() {
			return t;
		}

		public void setT(String t) {
			this.t = t;
		}
}
