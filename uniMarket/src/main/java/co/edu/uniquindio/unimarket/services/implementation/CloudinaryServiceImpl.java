package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.services.interfaces.CloudinaryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Service
public class CloudinaryServiceImpl implements CloudinaryService
{
    private final Cloudinary cloudinary;
    public CloudinaryServiceImpl()
    {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dodjc1s3m");
        config.put("api_key", "831334239485921");
        config.put("api_secret", "tCcuCkNYPS3NPkG0YvIjlUKAQzY");
        cloudinary = new Cloudinary(config);
    }
    @Override
    public Map uploadImage(File file, String carpeta) throws Exception
    {
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder",
                String.format("uniquindio/proyecto/%s", carpeta)));
    }
    @Override
    public Map deleteImage(String idImagen) throws Exception
    {
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }
    @Override
    public File convert(MultipartFile image) throws IOException
    {
        File file = File.createTempFile(image.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(image.getBytes());
        fos.close();
        return file;
    }
}