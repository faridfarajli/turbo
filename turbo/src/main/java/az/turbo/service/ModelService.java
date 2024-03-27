package az.turbo.service;



import az.turbo.dto.ModelDto;
import az.turbo.entity.Model;
import az.turbo.entity.ModelEnum;
import az.turbo.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ModelService {

    private final ModelRepository modelRepository;

    public Model createModel(ModelDto modelDto){
        Model model =  new Model();
        model.setId(model.getId());
        model.setName(modelDto.name());
        modelRepository.save(model);
        return model;
    }
}
