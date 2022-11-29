package computer;

import java.util.ArrayList;
import java.util.List;

public class Computer extends ComputerDevice{

    private List<ComputerDevice> components = new ArrayList<ComputerDevice>();

    // ComputerDevice 객체를 Computer 클래스에 추가
    public void addComponent(ComputerDevice computerDevice){
        components.add(computerDevice);
    }

    // ComputerDevice 객체를 Computer 클래스에 제거
    public void removeComponent(ComputerDevice computerDevice){
        components.remove(computerDevice);
    }

    //전체 가격 포함하는 각 부품의 가격 합산
    @Override
    public int getPrice() {
        return components.stream().mapToInt(ComputerDevice::getPrice).sum();
    }

    //소비 전력량 합산
    @Override
    public int getPower() {
        return components.stream().mapToInt(ComputerDevice::getPower).sum();
    }
}
