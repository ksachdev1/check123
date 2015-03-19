import com.dockerapis.rest.model.ippool.IpPoolCreate;
import com.google.gson.Gson;


public class PoolCreateTestGson {

	public static void main(String[] args) {
		IpPoolCreate poolObj = new IpPoolCreate();
		poolObj.setIpAddressRange("45.45.45.45");
		poolObj.setPoolName("princePool");
		poolObj.setSubnetMask("224.244.224.0");
		Gson gsonObj = new Gson();
		String myGson = gsonObj.toJson(poolObj);
		System.out.println(myGson);

	}

}
