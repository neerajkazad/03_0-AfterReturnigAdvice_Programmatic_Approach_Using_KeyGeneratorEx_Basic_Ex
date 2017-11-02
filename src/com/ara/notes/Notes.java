package com.ara.notes;

public class Notes {
	/**
	 * In this example We are Exploring about AfterReturningAdvice.
	 * If you want The GeneratedKey is weak then don't generate the week key simply return the
	 * exception throwing that "key len no supported/weak key generated".
	 * If key length = 8 then simply generated the key.
	 * 
	 * So We can say in AfterReturningAdvice Based on our Target class method output if we want to
	 * perform some cross cutting logic then we have to use AfterReturningAdvice.
	 * 
	 * Ex: KeyGenerator
	 * If keyLen < 8 //weak key 
	 * else
	 *    generate the key.
	 *    
	 *    
	 * Example With Code:
	 * 
	 * class KeyGenerator {
	 *   public int generateKey(int len) {
	 *     if(len < 8) {
	 *       return 0; //weak key
	 *     }
	 *     return 1;
	 *   }
	 * }
	 * 
	 * class KeyCheckAdvice implements AfterReturningAdvice {
	 *   public void afterReturning(Object ret, Method method, Object[] args, Object target) {
	 *     if((Integer) ret <= 0) {
	 *       throw new IlleagalArgumentException("Key len no supported/weak key generated");
	 *     } 
	 *   }
	 * }
	 * 
	 * class ARATest {
	 *   public static void main(String[] args) {
	 *     ProxyFactory pf = new ProxyFactory();
	 *     pf.setTarget(new KeyGenerator());
	 *     pf.addAdvice(new KeyCheckAdvice());
	 *     
	 *     KeyGenerator proxy = (KeyGenerator) pf.getProxy();
	 *     int key = proxy.generateKey(10); 
	 *     System.out.println("Key : "+key);
	 *     
	 *     key = proxy.generateKey(7); // weak key so here we are getting IllegalArgumentExcetion("Key len no supported/weak key generated");
	 *     //and we can perform cross cutting logic this is the use case related to AfterReturningAdvice. But this is the very basic use case.
	 *     System.out.println("Key : "+key);
	 *     
	 *   }
	 * }
	 */
}
