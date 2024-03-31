package tdd.mission.vendingMachine.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tdd.mission.vendingMachine.model.InputAmountReqDTO;
import tdd.mission.vendingMachine.service.VendingMachineService;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/vendingMachine")
@RestController
@Tag(name = "vendingMachine controller", description = "자판기 컨트롤러")
public class VendingMachineController {

    private final VendingMachineService vendingMachineService;

    /**
     *
     * randomCoinByinputAmont
     * 동전 무작위 생성
     *
     * @param inputAmount
     * @return InputAmountReqDTO
     */
    @PostMapping("/createCoin")
    public InputAmountReqDTO randomCoinByInputAmount(@RequestParam("inputAmount") int inputAmount) {
        return vendingMachineService.randomCoinByInputAmount(inputAmount);
    }

}
