package SpringBot.demo;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Maintesst {
	public static void main(String[] args) {
		try {
			String json="[{\"id\":1034848,\"acc\":82,\"asin\":\"B0BJ66H53F\",\"urlPreview\":\"https://zme-caps.amazon.com/asset/CSE/gear/baa6/71eda6d1-fd9e-4607-b243-dc70216da0d5_STANDARD_TSHIRT/SHIRT_ART_IMAGE_THUMBNAIL?versionId=1&awsClient=ApolloEnv%3AMerchDesignerWebApp%2FNA%2FProd&urlMethod=GET&expires=1688884349535&requestId=841eb913-c86f-4b8b-b61a-67b4ad1ab15e&sig=bd12d8f640293bde86043f0053c5a925e1d920c8eff2ece3bad18453364f6766&serial=21\",\"title\":\"English Grammar Police Funny Sarcasm Quotes Literary\",\"brand\":\"100 Days Smarter Hoodie 100th Day Of School Gift\",\"createDate\":1676566800000,\"userDelete\":null,\"dayUpdate\":1688835600000,\"username\":\"longtn\",\"pathProfile\":\"C:\\\\Users\\\\Administrator\\\\AppData\\\\Local\\\\Google\\\\Chrome\\\\User Data\\\\Profile 2\",\"typeProduct\":\"Standard t-shirt\",\"price\":\"JPY 2,000\",\"status\":\"Auto-uploaded\",\"accName\":\"merch 18 - jamyasemasen@gmail.com\",\"base64\":null,\"ip\":\"108.61.87.181\",\"mkt\":\".co.jp\",\"bobImage\":null}]";
			ObjectMapper objectMapper = new ObjectMapper();
			List<Product> mechlst = objectMapper.readValue(json, new TypeReference<List<Product>>() {
			});
			System.out.println(mechlst.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		String json="{\"APJ6JRA9NG5V4\":{\"unitsSold\":0,\"unitsCancelled\":0,\"unitsReturned\":0,\"revenueExclTax\":{\"value\":0,\"code\":\"EUR\"},\"royalties\":{\"value\":0,\"code\":\"EUR\"},\"revenue\":{\"value\":0,\"code\":\"EUR\"}},\"A13V1IB3VIYZZH\":{\"unitsSold\":0,\"unitsCancelled\":0,\"unitsReturned\":0,\"revenueExclTax\":{\"value\":0,\"code\":\"EUR\"},\"royalties\":{\"value\":0,\"code\":\"EUR\"},\"revenue\":{\"value\":0,\"code\":\"EUR\"}},\"A1RKKUPIHCS9HS\":{\"unitsSold\":0,\"unitsCancelled\":0,\"unitsReturned\":0,\"revenueExclTax\":{\"value\":0,\"code\":\"EUR\"},\"royalties\":{\"value\":0,\"code\":\"EUR\"},\"revenue\":{\"value\":0,\"code\":\"EUR\"}},\"A1VC38T7YXB528\":{\"unitsSold\":0,\"unitsCancelled\":0,\"unitsReturned\":0,\"revenueExclTax\":{\"value\":0,\"code\":\"JPY\"},\"royalties\":{\"value\":0,\"code\":\"JPY\"},\"revenue\":{\"value\":0,\"code\":\"JPY\"}},\"A1F83G8C2ARO7P\":{\"unitsSold\":0,\"unitsCancelled\":0,\"unitsReturned\":0,\"revenueExclTax\":{\"value\":0,\"code\":\"GBP\"},\"royalties\":{\"value\":0,\"code\":\"GBP\"},\"revenue\":{\"value\":0,\"code\":\"GBP\"}},\"A1PA6795UKMFR9\":{\"unitsSold\":0,\"unitsCancelled\":0,\"unitsReturned\":0,\"revenueExclTax\":{\"value\":0,\"code\":\"EUR\"},\"royalties\":{\"value\":0,\"code\":\"EUR\"},\"revenue\":{\"value\":0,\"code\":\"EUR\"}},\"ATVPDKIKX0DER\":{\"unitsSold\":2,\"unitsCancelled\":0,\"unitsReturned\":0,\"revenueExclTax\":{\"value\":35.98,\"code\":\"USD\"},\"royalties\":{\"value\":5.53,\"code\":\"USD\"},\"revenue\":{\"value\":35.98,\"code\":\"USD\"}}}";
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		
//		AllSaleDTO dto;
//		try {
//			dto = objectMapper.readValue(json, AllSaleDTO.class);
//			System.out.println(dto.getaTVPDKIKX0DER().unitsSold);
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Product> lsrPro=new ArrayList<>();
//		Product pro = new Product();
//		pro.setAsin("123");
//		pro.setAcc(123);
//		pro.setBrand("123");
//		pro.setMkt("123");
//		pro.setTypeProduct("123");
//		pro.setCreateDate(new Date());
//		pro.setPrice("123");
//		pro.setStatus("123");
//		pro.setIp("123");
//		pro.setPathProfile("123");
//		pro.setTitle("123");
//		pro.setUrlPreview("123");
//		lsrPro.add(pro);
//		ListPoductDTO listPoductDTO=new ListPoductDTO();
//		listPoductDTO.setList(lsrPro);
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			String jsonString = objectMapper.writeValueAsString(listPoductDTO);
//			System.out.println(jsonString);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		
		try {
			
			Path path = Paths.get("C:\\Users\\longtn\\Downloads\\product\\123.png");
			System.out.println(path.toString());
//			java.net.URL url = new java.net.URL("https://zme-caps.amazon.com/asset/CSE/gear/a8be/8b011667-2c3a-47c2-8670-266f7917c190_PREMIUM_TSHIRT/SHIRT_ART_IMAGE_THUMBNAIL?versionId=1&awsClient=ApolloEnv%3AMerchDesignerWebApp%2FNA%2FProd&urlMethod=GET&expires=1688842413960&requestId=a464cf07-8695-4bfb-870d-3d33aacba070&sig=f44c23e9506c027b5e104f41a706b96b7e952dca70cd412f68ecc015e9c4ba6e&serial=21"); 
//		    InputStream is = url.openStream();  
//		    byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(is); 
//		    String encodedString = Base64.getEncoder().encodeToString(bytes);
//		    System.out.println(encodedString);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
//		String json="{\"dailyProduct\":{\"count\":0,\"limit\":200},\"overallProduct\":{\"count\":499,\"limit\":33000},\"overallDesign\":{\"count\":428,\"limit\":500}}";
//		
//		
//		
//		
//		try {
//			Meta dto = objectMapper.readValue(json, Meta.class);
//			int count=dto.getOverallProduct().getCount()/250;
//			int phandu=dto.getOverallProduct().getCount() % 250;
//			if(phandu==0)
//			{
//				count=count-1;
//			}
//			if(dto.getOverallProduct().getCount()<=250)
//			{
//				count=0;
//			}
//			System.out.println(count);
//			
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
		
		
		
//		String link="https://www.amazon.com/dp/B0B71GNPX8";
//		int x=link.lastIndexOf("/");
//		String b=link.substring(x+1);
//		System.out.println(b);
		
	}

}
