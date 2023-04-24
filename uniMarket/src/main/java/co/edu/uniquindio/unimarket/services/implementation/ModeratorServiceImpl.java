package co.edu.uniquindio.unimarket.services.implementation;

import co.edu.uniquindio.unimarket.model.Moderator;
import co.edu.uniquindio.unimarket.model.State;
import co.edu.uniquindio.unimarket.services.interfaces.ModeratorService;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeratorServiceImpl implements ModeratorService
{
    private  final ProductService productService;

    @Override
    public boolean updateState(int productCode, State state) throws Exception
    {
        boolean answer = false;

        if (productService.updateForState(productCode, state) > 0 )
        {
            answer = true;
        }

        return answer;
    }
}
