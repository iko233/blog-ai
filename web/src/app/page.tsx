'use client';
import { useEffect, useState } from 'react';
import { List } from 'antd';
import axios from 'axios';

interface Article {
  id: number;
  title: string;
  content: string;
}

export default function Home() {
  const [articles, setArticles] = useState<Article[]>([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/articles').then(r => setArticles(r.data));
  }, []);

  return (
    <List
      style={{margin: '20px'}}
      header={<div>Articles</div>}
      bordered
      dataSource={articles}
      renderItem={(item) => (
        <List.Item>
          <List.Item.Meta title={item.title} description={item.content}/>
        </List.Item>
      )}
    />
  );
}
