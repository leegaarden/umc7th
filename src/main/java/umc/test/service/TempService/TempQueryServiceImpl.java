package umc.test.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.test.apiPayload.code.status.ErrorStatus;
import umc.test.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 2)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
