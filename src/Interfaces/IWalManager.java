package Interfaces;

import Utilities.Tuple;

import java.util.HashMap;

public interface IWalManager {

    void UpdateWal(HashMap<Float, Object> data);
    void UpdateWal(Tuple<Float, Object> data);
}
