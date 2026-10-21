package com.otax.clone;
import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

public class AutoService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        AccessibilityNodeInfo root = getRootInActiveWindow();
        if (root == null) return;
        List<AccessibilityNodeInfo> btn = root.findAccessibilityNodeInfosByViewId("com.whatsapp:id/send");
        if (btn != null && !btn.isEmpty()) {
            for (AccessibilityNodeInfo b : btn) {
                if (b.isClickable()) { b.performAction(AccessibilityNodeInfo.ACTION_CLICK); break; }
            }
        }
    }
    @Override public void onInterrupt() {}
}
