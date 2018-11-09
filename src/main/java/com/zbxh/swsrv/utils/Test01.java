package com.zbxh.swsrv.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zbxh.swsrv.entity.User;

public class Test01 {
    List<User> students =new ArrayList<User>();

    public void readXMLDemo() throws Exception {
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document document = reader.read(new File("src/main/resources/students.xml"));
        //获取根节点元素对象
        Element node = document.getRootElement();
        //遍历所有的元素节点
        listNodes(node);

        for (User student : students) {
            System.out.println(student);
        }
    }

    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *
     * @param node
     */
    public void listNodes(Element node) {
        System.out.println("当前节点的名称：：" + node.getName());
        // 获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        // 遍历属性节点
        for (Attribute attr : list) {
            System.out.println(attr.getText() + "-----" + attr.getName()
                    + "---" + attr.getValue());
            if (!(node.getTextTrim().equals(""))) {
                System.out.println("文本内容：：：：" + node.getText());
                User user=new User();
                user.setUsername(node.getText());
                user.setTel(attr.getValue());
                user.setDepartment(attr.getParent().getParent().attribute(0).getValue());
                students.add(user);
            }
        }
        // 当前节点下面子节点迭代器
        Iterator<Element> it = node.elementIterator();
        // 遍历
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element e = it.next();
            // 对子节点进行遍历
            listNodes(e);
        }
    }
}
