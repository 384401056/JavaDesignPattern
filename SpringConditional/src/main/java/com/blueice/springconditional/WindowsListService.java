package com.blueice.springconditional;

/**
 * Created by Administrator on 2017/4/5.
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
