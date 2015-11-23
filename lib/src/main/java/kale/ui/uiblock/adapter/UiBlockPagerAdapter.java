package kale.ui.uiblock.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kale.ui.uiblock.UIBlock;
import kale.ui.uiblock.UiBlockManager;

/**
 * @author Jack Tony
 * @date 2015/11/21
 */
public class UiBlockPagerAdapter extends CommonPagerAdapter<UIBlock>{

    private final UiBlockManager mManager;

    public UiBlockPagerAdapter(UiBlockManager manager, List<UIBlock> items) {
        super(items);
        mManager = manager;
    }

    @Override
    public View onInitItem(ViewGroup container, UIBlock UIBlock, int position) {
        mManager.add(UIBlock);
        container.addView(UIBlock.getRootView());
        return UIBlock.getRootView();
    }

    @Override
    public void onDestroyItem(ViewGroup container, UIBlock UIBlock, int position, View view) {
        container.removeView(view);
        mManager.remove(UIBlock);
    }
}
