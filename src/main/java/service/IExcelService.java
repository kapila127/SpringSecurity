
package service;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface IExcelService {
   public void uploadToExcel( CommonsMultipartFile bean);
}
