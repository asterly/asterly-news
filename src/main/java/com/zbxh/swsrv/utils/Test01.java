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
        // ����saxReader����
        SAXReader reader = new SAXReader();
        // ͨ��read������ȡһ���ļ� ת����Document����
        Document document = reader.read(new File("src/main/resources/students.xml"));
        //��ȡ���ڵ�Ԫ�ض���
        Element node = document.getRootElement();
        //�������е�Ԫ�ؽڵ�
        listNodes(node);

        for (User student : students) {
            System.out.println(student);
        }
    }

    /**
     * ������ǰ�ڵ�Ԫ�����������(Ԫ�ص�)�ӽڵ�
     *
     * @param node
     */
    public void listNodes(Element node) {
        System.out.println("��ǰ�ڵ�����ƣ���" + node.getName());
        // ��ȡ��ǰ�ڵ���������Խڵ�
        List<Attribute> list = node.attributes();
        // �������Խڵ�
        for (Attribute attr : list) {
            System.out.println(attr.getText() + "-----" + attr.getName()
                    + "---" + attr.getValue());
            if (!(node.getTextTrim().equals(""))) {
                System.out.println("�ı����ݣ�������" + node.getText());
                User user=new User();
                user.setUsername(node.getText());
                user.setTel(attr.getValue());
                user.setDepartment(attr.getParent().getParent().attribute(0).getValue());
                students.add(user);
            }
        }
        // ��ǰ�ڵ������ӽڵ������
        Iterator<Element> it = node.elementIterator();
        // ����
        while (it.hasNext()) {
            // ��ȡĳ���ӽڵ����
            Element e = it.next();
            // ���ӽڵ���б���
            listNodes(e);
        }
    }
}
