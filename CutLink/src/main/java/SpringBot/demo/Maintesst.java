package SpringBot.demo;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Maintesst {
	public static void main(String[] args) {
		
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
		
		
		
		String json="{\"dailyProduct\":{\"count\":0,\"limit\":200},\"overallProduct\":{\"count\":499,\"limit\":33000},\"overallDesign\":{\"count\":428,\"limit\":500}}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		try {
			Meta dto = objectMapper.readValue(json, Meta.class);
			int count=dto.getOverallProduct().getCount()/250;
			int phandu=dto.getOverallProduct().getCount() % 250;
			if(phandu==0)
			{
				count=count-1;
			}
			if(dto.getOverallProduct().getCount()<=250)
			{
				count=0;
			}
			System.out.println(count);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		
		
//		String link="https://www.amazon.com/dp/B0B71GNPX8";
//		int x=link.lastIndexOf("/");
//		String b=link.substring(x+1);
//		System.out.println(b);
		
	}

}
